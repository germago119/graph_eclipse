package org.tec.datos1.graph.eclipse.assets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;


public class ActiveStatement implements Widget {
		
	String text;
	Point input;
	Point output;
	
	public ActiveStatement(String text, Point input) {
		this.text = text;
		this.input = input;
		this.output = new Point(input.x, input.y + 40);
	}
	
	public ActiveStatement(String text, int x, int y) {
		this(text, new Point(x, y));
	}
	
	public Point getOutput() {
		return output;
	}
	
	public Point getInput() {
		return input;
	}
	
	@Override
	public void sketch(GC gc) {
		Rectangle rectangle = new Rectangle(input.x - 10 - gc.stringExtent(text).x / 2, input.y, gc.stringExtent(text).x + 20, 40);
		gc.drawRectangle(rectangle);
		gc.drawText(text, input.x - gc.stringExtent(text).x / 2, input.y + (40 - gc.stringExtent(text).y) / 2);
	}
}
