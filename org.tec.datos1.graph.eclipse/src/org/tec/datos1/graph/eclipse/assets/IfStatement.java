package org.tec.datos1.graph.eclipse.assets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

public class IfStatement implements Widget {
	
	String text;
	Point input;
	Point outputT;
	Point outputF;
	GC gc;
	Rectangle focus;
	int[] shape;
	
	
	public IfStatement(String text, Point input) {
		this.text = text;
		this.input = input;
		this.outputT = new Point(input.x - 30 - gc.stringExtent(text).x / 2, input.y + gc.stringExtent(text).y / 2 + 20);
		this.outputF = new Point(input.x + 30 + gc.stringExtent(text).x / 2, input.y + gc.stringExtent(text).y / 2 + 20);
		shape = new int[] {input.x, input.y, outputF.x, outputF.y, input.x, input.y + gc.stringExtent(text).y + 40, outputT.x, outputT.y};
	}
	
	public IfStatement(String text, int x, int y) {
		this(text, new Point(x, y));
	}
	
	public Point getInput() {
		return input;
	}
	
	public Point getOutputT() {
		return outputT;
	}
	
	public Point getOutputF() {
		return outputF;
	}
	
	public void end() {
		this.focus = null;
	}
	
	@Override
	public void sketch(GC gc) {
		gc.drawPolygon(shape);
		gc.drawText(text, input.x - gc.stringExtent(text).x / 2, input.y + 20);
	}
	
}
