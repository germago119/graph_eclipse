package org.tec.datos1.graph.eclipse.data;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;

public class ASTData {

	static ASTData root;
	String name;
	ASTNode element;
	List<ASTData> children;
	public Boolean after;
	static CompilationUnit compilationUnit;
	
	
	public ASTData(ASTNode element,String name) {
		this.element = element;
		this.children = new ArrayList<ASTData>();
		this.name = name;
	}
	
	public ASTData(ASTNode element,Boolean after,String name) {
		this(element,name);
		this.after = after;
	}
	
	public static ASTData getRoot(){
		return root;
	}
	
	public static void setRoot(ASTData Root) {
		root = Root;
	}
	
	public ASTNode getElement() {
		return this.element;
	}
	
	public List<ASTData> getChildren(){
		return children;
	}
	
	public void setAfter() {
		this.after = true;
	}
	
	public String getName() {
		return this.name;
	}

	public static void setcompilationUnit(CompilationUnit Unit) {
		compilationUnit = Unit;
	}
	
	public static List<String> getMethods() {
		List<String> result = new ArrayList<>();
		if (root == null) {
			return null;
		}
		for (ASTData method :root.getChildren()) {
			result.add(method.getName());
		}
		return result;
	}
	
	public static ASTData getMethod(String Method) {
		for (ASTData method :root.getChildren()) {
			if (method.getName().equals(Method)) return method;
		}
		return null;
	}
	
	public void addChild(ASTData Child) {
		children.add(Child);
	}
	//Busca la linea de codigo dentro del ASTData
	public ASTData findLine(Integer lineNumber) {
		
		if (element != null && (compilationUnit.getLineNumber(element.getStartPosition()) == lineNumber)) {
			return this;
		}else if (children.size() != 0) {
			for (ASTData child : children) {
				ASTData tempNode = child.findLine(lineNumber);
				if ( tempNode != null)
					return tempNode;
			}
		}
		return null;
	}
	
	
   //Cambia el AST de Eclipse a una estructura definida por mi
    public void addChildren(List<Block> Statements) {
    	
    	for (Object statement : Statements) {
			ASTNode child = (ASTNode) statement;
			this.addChildrenAux(child);
    	}
    }
    
    public void deleteChildren() {
    	this.children.clear();
    	ASTData.root = null;
    }
    
    
    //MAE OCUPO QUE METAS LOS BLOQUES DE CODIGO ACA, QUE A PUROS IF VERIFIQUE SI ES UN wHILE
    //POR EJEMPLO Y LE APLIQUE UN THIS.ADDCHILD(WHILESTORAGE) Y UN WHILESTORAGE.ADDCHILDREN(BLOCK.STATEMENTS())
    //POR ESO IMPORTE UN MONTON DE VARAS
    public void addChildrenAux(ASTNode child) {}
    //TODO

    //TODO PRINT ARBOL
    
    public void print() throws ScriptException {
		if (element == null) {
			if (this.after) {
				
			}else {
				System.out.println("Else: ");
			}

		} else {
			//IF PARA CADA STATEMNET Y UN PRINT
		}
		
		
		for (ASTData child : children) {
			child.print();

		}	
    
    }

}
	
	
	
	
	
	
	
