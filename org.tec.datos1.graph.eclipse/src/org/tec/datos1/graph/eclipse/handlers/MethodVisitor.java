package org.tec.datos1.graph.eclipse.handlers;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.core.dom.*;

public class MethodVisitor extends ASTVisitor {
	List<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();
	/**
	 * metodo visit del ASTNode el cual extrae el metodo, lo agrega a la lista
	 * @param node Expresion de codigo
	 * @return "true" para revisar los hijos
	 */
	
	@Override
	public boolean visit(MethodDeclaration node) {

		methods.add(node);
		return super.visit(node);
	}
	
	public List<MethodDeclaration> getMethods() {
		return methods;
	}
}