/*
 * Copyright (c) 1999-2003, Carnegie Mellon University. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 
 * 3. Products derived from the software may not be called "Alice",
 *    nor may "Alice" appear in their name, without prior written
 *    permission of Carnegie Mellon University.
 * 
 * 4. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    "This product includes software developed by Carnegie Mellon University"
 */

package edu.cmu.cs.stage3.alice.authoringtool.util;

import java.awt.*;
import javax.swing.*;

/**
 * @author Jason Pratt
 */
public class ScriptScratchPad extends javax.swing.JPanel {
	protected edu.cmu.cs.stage3.alice.authoringtool.util.ScriptEditorPane scriptEditorPane = new edu.cmu.cs.stage3.alice.authoringtool.util.ScriptEditorPane();
	protected javax.swing.JScrollPane scriptScrollPane = new javax.swing.JScrollPane();

	public ScriptScratchPad() {
		jbInit();
		guiInit();
	}

	private void guiInit() {
		scriptScrollPane.setViewportView( scriptEditorPane );
		scriptPanel.add( scriptScrollPane, java.awt.BorderLayout.CENTER );
		performAllButton.setAction( scriptEditorPane.performAllAction );
		performSelectedButton.setAction( scriptEditorPane.performSelectedAction );
	}

	public void setSandbox( edu.cmu.cs.stage3.alice.core.Sandbox sandbox ) {
		scriptEditorPane.setSandbox( sandbox );
	}

	public void setTitleEnabled( boolean b ) {
		if( b ) {
			this.add( scratchPadLabel, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(1, 4, 1, 4), 0, 0) );
		} else {
			this.remove( scratchPadLabel );
		}
	}

	/////////////////////
	// Autogenerated
	/////////////////////

	GridBagLayout gridBagLayout1 = new GridBagLayout();
	JPanel scriptPanel = new JPanel();
	BorderLayout borderLayout1 = new BorderLayout();
	JButton performAllButton = new JButton();
	JButton performSelectedButton = new JButton();
	JLabel scratchPadLabel = new JLabel();

	private void jbInit() {
		this.setLayout(gridBagLayout1);
		scriptPanel.setLayout(borderLayout1);
		performAllButton.setText(java.util.ResourceBundle.getBundle("edu/cmu/cs/stage3/alice/authoringtool/util/ScriptScratchPad").getString("perform_all_(Ctrl-F4)"));
		performSelectedButton.setText(java.util.ResourceBundle.getBundle("edu/cmu/cs/stage3/alice/authoringtool/util/ScriptScratchPad").getString("perform_selected_(F4)"));
		scratchPadLabel.setFont(new java.awt.Font("Dialog", 1, 16));
		scratchPadLabel.setText(java.util.ResourceBundle.getBundle("edu/cmu/cs/stage3/alice/authoringtool/util/ScriptScratchPad").getString("Scratch_Pad"));
		this.add(scriptPanel, new GridBagConstraints(0, 1, 3, 1, 1.0, 1.0
			,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		this.add(performSelectedButton, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
			,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(4, 4, 4, 4), 0, 0));
		this.add(performAllButton, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
			,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(4, 4, 4, 4), 0, 0));
		this.add(scratchPadLabel, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0
			,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(1, 4, 1, 4), 0, 0));
	}
}