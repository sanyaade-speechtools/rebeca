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

package edu.cmu.cs.stage3.alice.authoringtool.viewcontroller;

/**
 * @author Jason Pratt
 * @deprecated  use ElementNamePropertyViewController
 */
public class RightClickNameEditor extends StringPropertyViewController {
	public RightClickNameEditor( final edu.cmu.cs.stage3.alice.core.Element element ) {
		super.set( element.name, false, true, true, new edu.cmu.cs.stage3.alice.authoringtool.util.PopupItemFactory() {
			public Object createItem( final Object value ) {
				return new Runnable() {
					public void run() {
						element.name.set( value );
					}
				};
			}
		} );
		popupStructure = new java.util.Vector();
		popupStructure.add( new edu.cmu.cs.stage3.util.StringObjectPair( java.util.ResourceBundle.getBundle("edu/cmu/cs/stage3/alice/authoringtool/viewcontroller/RightClickNameEditor").getString("Rename"), new Runnable() {
			public void run() {
				RightClickNameEditor.this.editValue();
			}
		}));
		setPopupEnabled( false );
	}

	protected java.awt.event.MouseListener getMouseListener() {
		return new java.awt.event.MouseAdapter() {
			public void mouseReleased( java.awt.event.MouseEvent ev ) {
				if( isEnabled() && ev.isPopupTrigger() ) {
					RightClickNameEditor.this.popupButton.doClick();
				}
			}
		};
	}

	protected void updatePopupStructure() {}
}
