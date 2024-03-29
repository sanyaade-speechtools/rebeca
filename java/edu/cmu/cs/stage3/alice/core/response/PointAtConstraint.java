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

package edu.cmu.cs.stage3.alice.core.response;

import edu.cmu.cs.stage3.alice.core.property.BooleanProperty;

public class PointAtConstraint extends AbstractPointAtConstraint {
	public final BooleanProperty onlyAffectYaw = new BooleanProperty( this, "onlyAffectYaw", Boolean.FALSE );
	public class RuntimePointAtConstraint extends RuntimeAbstractPointAtConstraint {
		protected boolean onlyAffectYaw() {
			return PointAtConstraint.this.onlyAffectYaw.booleanValue();
		}
		public void prologue( double t ) {
			super.prologue( t );
			if( PointAtConstraint.this.onlyAffectYaw.getValue() == null ) {
				throw new edu.cmu.cs.stage3.alice.core.SimulationPropertyException( java.util.ResourceBundle.getBundle("edu/cmu/cs/stage3/alice/core/response/PointAtConstraint").getString("only_affect_yaw_value_must_not_be_null."), null, PointAtConstraint.this.onlyAffectYaw );
			}
		}
	}
}
