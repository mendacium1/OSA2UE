package test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import comment.Comment;

public class ProcessComments {

	public static void main(String[] args) {
		Annotation[] annotations = CommentedClass.class.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}

		Field[] fields = CommentedClass.class.getDeclaredFields();
		for (Field field : fields) {
			Comment annotation = field.getAnnotation(Comment.class);
			if (annotation != null) {
				System.out.println(field.getName() + ": " + annotation.text());
			}
		}
	}

}
