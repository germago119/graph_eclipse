package org.tec.datos1.graph.eclipse.parts;

import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;


public class FlowDiagramView {
	Canvas canvas;

	@Inject
	public FlowDiagramView(Composite parent) {
		//Aca se llama a la estructura donde se guardan los datos y se refrencia esta instancia
		
		ScrolledComposite container = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		this.canvas = new Canvas(container, SWT.NONE);
		canvas.setSize(1000, 1000);
		container.setContent(canvas);
		
		canvas.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
			}
		});
	}
	
	public void draw() { 
		canvas.redraw();
	}
}
