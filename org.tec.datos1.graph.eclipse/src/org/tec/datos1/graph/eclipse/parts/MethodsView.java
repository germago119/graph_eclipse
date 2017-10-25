package org.tec.datos1.graph.eclipse.parts;

import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class MethodsView {
	@Inject
	public MethodsView(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("Test1");
	}
}
