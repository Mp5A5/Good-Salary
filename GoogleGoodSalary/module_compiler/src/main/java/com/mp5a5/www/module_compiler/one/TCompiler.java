package com.mp5a5.www.module_compiler.one;

import com.google.auto.service.AutoService;
import com.mp5a5.www.module_annotation.FindId;
import com.mp5a5.www.module_annotation.OnClick;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：mp5a5 on 2019-05-21 16：20
 * @describe ：
 * @email ：wwb199055@126.com
 */
@AutoService(Processor.class)
public class TCompiler extends AbstractProcessor {

    /**
     * 一个需要生成的类的集合（key为类的全名，value为该类所有相关的需要的信息）
     */
    private Map<String, ProxyInfo> mProxyMap = new HashMap<String, ProxyInfo>();
    //跟文件相关的辅助类，生成JavaSourceCode.
    private Filer mFileUtils;
    //跟元素相关的辅助类，帮助我们去获取一些元素相关的信息。
    private Elements mElementUtils;
    //跟日志相关的辅助类。
    private Messager mMessager;

    //初始化一些变量信息
    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mFileUtils = processingEnvironment.getFiler();
        mElementUtils = processingEnvironment.getElementUtils();
        mMessager = processingEnvironment.getMessager();
    }

    /**
     * getSupportedSourceVersion主要是声明支持的Java源码版本
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_8;
    }

    /**
     * getSupportedAnnotationTypes主要是声明 Processor 处理的注解，注意这是一个数组，表示可以处理多个注解，如果少加了，那么这个注解肯定不会生效的
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotationTypes = new LinkedHashSet<>();
        annotationTypes.add(FindId.class.getCanonicalName());
        annotationTypes.add(OnClick.class.getCanonicalName());
        return annotationTypes;
    }

    /**
     * process方法的实现需要分为两个步骤走：
     * <p>
     * 需要生成的类的所有信息的收集
     * 根据收集的信息生成具体的java代码
     */
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        collectionInfo(roundEnvironment);
        generateClass();
        return true;
    }

    /**
     * 生成代理类
     */
    private void generateClass() {
        for (String key : mProxyMap.keySet()) {
            ProxyInfo info = mProxyMap.get(key);
            JavaFileObject sourceFile = null;
            try {
                sourceFile=mFileUtils.createSourceFile(info.getProxyClassFullName(),info.typeElement);
                Writer writer = sourceFile.openWriter();
                writer.write(info.generateJavaCode());
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                error(info.typeElement, "===tb===%s", e.getMessage());
            }
        }
    }

    private void print(String message) {
        mMessager.printMessage(Diagnostic.Kind.NOTE, message);
    }

    private void error(Element element, String message, Object... args) {
        if (args.length > 0) {
            message = String.format(message, args);
        }
        mMessager.printMessage(Diagnostic.Kind.ERROR, message, element);
    }

    /**
     * 收集所需生成类的信息
     */
    private void collectionInfo(RoundEnvironment roundEnvironment) {
        //process可能会多次调用，避免生成重复的代理类
        mProxyMap.clear();
        //获得被该注解声明的类和变量
        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(FindId.class);
        //收集信息
        for (Element element : elements) {
            if (element.getKind() == ElementKind.CLASS) {
                //获取注解的值
                TypeElement typeElement = (TypeElement) element;
                //类的完整路径
                String qualifiedName = typeElement.getQualifiedName().toString();
                //类名
                String clsName = typeElement.getSimpleName().toString();
                //获取包名
                String packageName = mElementUtils.getPackageOf(typeElement).toString();
                FindId findId = element.getAnnotation(FindId.class);
                if (findId != null) {
                    int value = findId.value();
                    //处理类注解
                    ProxyInfo proxyInfo = mProxyMap.get(qualifiedName);
                    if (proxyInfo == null) {
                        proxyInfo = new ProxyInfo();
                        mProxyMap.put(qualifiedName, proxyInfo);
                    }
                    proxyInfo.value = value;
                    proxyInfo.typeElement = typeElement;
                    proxyInfo.packageName = packageName;
                }
            } else if (element.getKind() == ElementKind.FIELD) {
                //获取注解的值
                FindId findId = element.getAnnotation(FindId.class);
                if (findId != null) {
                    int value = findId.value();
                    //处理成员变量注解
                    VariableElement variableElement = (VariableElement) element;
                    //这里先要获取上层封装类型，然后强转为TypeElement
                    String qualifiedName = ((TypeElement) element.getEnclosingElement()).getQualifiedName().toString();
                    ProxyInfo proxyInfo = mProxyMap.get(qualifiedName);
                    if (proxyInfo == null) {
                        proxyInfo = new ProxyInfo();
                        mProxyMap.put(qualifiedName, proxyInfo);
                    }
                    proxyInfo.mInjectElements.put(value, variableElement);
                } else {
                    continue;
                }
            }

            //获得被该注解声明的方法
            Set<? extends Element> elementsMethods = roundEnvironment.getElementsAnnotatedWith(OnClick.class);
            for (Element elementsMethod : elementsMethods) {
                if (elementsMethod.getKind() == ElementKind.METHOD) {
                    //获取注解的值
                    OnClick onClick = elementsMethod.getAnnotation(OnClick.class);
                    if (onClick != null) {
                        int[] value = onClick.value();
                        if (value != null && value.length > 0) {
                            for (int i = 0; i < value.length; i++) {
                                ExecutableElement executableElement = (ExecutableElement) element;
                                //这里先要获取上层封装类型，然后强转为TypeElement
                                String qualifiedName = ((TypeElement) element.getEnclosingElement()).getQualifiedName().toString();
                                ProxyInfo proxyInfo = mProxyMap.get(qualifiedName);
                                if (proxyInfo == null) {
                                    proxyInfo = new ProxyInfo();
                                    mProxyMap.put(qualifiedName, proxyInfo);
                                }
                                proxyInfo.mInjectMethods.put(value[i], executableElement);
                            }
                        }
                    }
                } else {
                    continue;
                }
            }
        }
    }
}
