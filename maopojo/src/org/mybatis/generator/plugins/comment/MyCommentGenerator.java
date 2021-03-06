package org.mybatis.generator.plugins.comment;

import java.util.Properties;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class MyCommentGenerator implements CommentGenerator {

	@Override
	public void addConfigurationProperties(Properties properties) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addFieldComment(Field field,
			IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		// TODO Auto-generated method stub
		if (introspectedColumn.getRemarks() != null
				&& !introspectedColumn.getRemarks().equals("")) {
			field.addJavaDocLine("/**");
			field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
			// addJavadocTag(field, false);
			field.addJavaDocLine(" */");

			field.addAnnotation("@Column(name = \""
					+ introspectedColumn.getActualColumnName() + "\")");

			if (introspectedColumn.getActualColumnName().equals("id")) {
				field.addAnnotation("@Id");
				field.addAnnotation(
						"@GeneratedValue(strategy = GenerationType.IDENTITY, generator = \"SELECT LAST_INSERT_ID()\")");
			}
		}
	}

	@Override
	public void addFieldComment(Field field,
			IntrospectedTable introspectedTable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addClassComment(InnerClass innerClass,
			IntrospectedTable introspectedTable) {
		// TODO Auto-generated method stub
		innerClass.addAnnotation("@Table(name=\""
				+ introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()
				+ "\")");
	}

	@Override
	public void addClassComment(InnerClass innerClass,
			IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEnumComment(InnerEnum innerEnum,
			IntrospectedTable introspectedTable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addGetterComment(Method method,
			IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSetterComment(Method method,
			IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addGeneralMethodComment(Method method,
			IntrospectedTable introspectedTable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addJavaFileComment(CompilationUnit compilationUnit) {
		// TODO Auto-generated method stub

		// 添加要导入的包
		compilationUnit.addImportedType(
				new FullyQualifiedJavaType("javax.persistence.Column"));
		// 添加要导入的包
		compilationUnit.addImportedType(
				new FullyQualifiedJavaType("javax.persistence.Table"));
		// 添加要导入的包
		compilationUnit.addImportedType(
				new FullyQualifiedJavaType("javax.persistence.Id"));
		// 添加要导入的包
		compilationUnit.addImportedType(
				new FullyQualifiedJavaType("javax.persistence.GeneratedValue"));
		// 添加要导入的包
		compilationUnit.addImportedType(
				new FullyQualifiedJavaType("javax.persistence.GenerationType"));
	}

	@Override
	public void addComment(XmlElement xmlElement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRootComment(XmlElement rootElement) {
		// TODO Auto-generated method stub

	}

}
