package org.tec.datos1.graph.eclipse.handlers;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.core.dom.*;

public class MethodVisitor extends ASTVisitor {
	List<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();
	
	
	@Override
	public boolean visit(MethodDeclaration node) {

		methods.add(node);
		return super.visit(node);
	}
	
	public List<MethodDeclaration> getMethods() {
		return methods;
	}
}