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

package edu.cmu.cs.stage3.alice.authoringtool.dialog;

public class LoadElementProgressPane extends edu.cmu.cs.stage3.progress.ProgressPane {
	private edu.cmu.cs.stage3.io.DirectoryTreeLoader m_loader;
	private edu.cmu.cs.stage3.alice.core.Element m_externalRoot;
	private edu.cmu.cs.stage3.alice.core.Element m_loadedElement;
	public LoadElementProgressPane( String title, String preDescription ) {
		super( title, preDescription );
	}
	protected void construct() throws edu.cmu.cs.stage3.progress.ProgressCancelException {
		m_loadedElement = null;
		try {
			m_loadedElement = edu.cmu.cs.stage3.alice.core.Element.load( m_loader, m_externalRoot, this );
		} catch( edu.cmu.cs.stage3.progress.ProgressCancelException pce ) {
			throw pce;
		} catch( edu.cmu.cs.stage3.alice.core.UnresolvablePropertyReferencesException upre ) {
			//edu.cmu.cs.stage3.alice.authoringtool.dialog.UnresolvablePropertyReferencesPane unresolvablePropertyReferencesPane = new edu.cmu.cs.stage3.alice.authoringtool.dialog.UnresolvablePropertyReferencesPane( upre );
			//edu.cmu.cs.stage3.swing.DialogManager.showDialog( unresolvablePropertyReferencesPane );
			StringBuffer sb = new StringBuffer();
			sb.append( java.util.ResourceBundle.getBundle("edu/cmu/cs/stage3/alice/authoringtool/dialog/LoadElementProgressPane").getString("WARNING:_unable_to_resolve_references:_\n") );
			edu.cmu.cs.stage3.alice.core.reference.PropertyReference[] propertyReferences = upre.getPropertyReferences();
			for( int i=0; i<propertyReferences.length; i++ ) {
				edu.cmu.cs.stage3.alice.core.Property property = propertyReferences[ i ].getProperty();
				sb.append( "    " );
				sb.append( property.getOwner().toString() );
				sb.append( '[' );
				sb.append( property.getName() );
				sb.append( "] -> " );
				sb.append( propertyReferences[ i ].getCriterion() );
				sb.append( '\n' );
			}
			sb.append( '\n' );
			sb.append( java.util.ResourceBundle.getBundle("edu/cmu/cs/stage3/alice/authoringtool/dialog/LoadElementProgressPane").getString("Would_you_like_to_continue,_setting_all_values_to_None?") );
			if( edu.cmu.cs.stage3.swing.DialogManager.showConfirmDialog( sb.toString(), java.util.ResourceBundle.getBundle("edu/cmu/cs/stage3/alice/authoringtool/dialog/LoadElementProgressPane").getString("Unable_to_load_world"), javax.swing.JOptionPane.YES_NO_OPTION ) == javax.swing.JOptionPane.YES_OPTION ) {
				m_loadedElement = upre.getElement();
			}
		} catch( Throwable t ) {
			edu.cmu.cs.stage3.alice.authoringtool.AuthoringTool.showErrorDialog( java.util.ResourceBundle.getBundle("edu/cmu/cs/stage3/alice/authoringtool/dialog/LoadElementProgressPane").getString("Unable_to_load_world"), t );
		}
//		} catch( edu.cmu.cs.stage3.alice.core.UnresolvablePropertyReferencesException upre ) {
//			javax.swing.SwingUtilities.invokeAndWait( new Runnable() {
//				public void run() {
//					edu.cmu.cs.stage3.alice.authoringtool.dialog.UnresolvablePropertyReferencesPane unresolvablePropertyReferencesPane = new edu.cmu.cs.stage3.alice.authoringtool.dialog.UnresolvablePropertyReferencesPane( upre );
//					edu.cmu.cs.stage3.swing.DialogManager.showDialog( unresolvablePropertyReferencesPane );
//				}
//			} );
//			edu.cmu.cs.stage3.alice.core.reference.PropertyReference[] propertyReferences = e.getPropertyReferences();
//			//System.err.println("Unable to load object: " + pathname + ".  Couldn't resolve the following references:");
//			for (int i = 0; i < propertyReferences.length; i++) {
//				System.err.println("\t" + propertyReferences[i]);
//			}
//		}
	}
	public void setLoader( edu.cmu.cs.stage3.io.DirectoryTreeLoader loader ) {
		m_loader = loader;
	}
	public void setExternalRoot( edu.cmu.cs.stage3.alice.core.Element externalRoot ) {
		m_externalRoot = externalRoot;
	}
	public edu.cmu.cs.stage3.alice.core.Element getLoadedElement() {
		return m_loadedElement;
	}
}
