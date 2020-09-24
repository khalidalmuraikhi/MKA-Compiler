/*
 *  ========================================================================
 *  uA Interpreter
 *  ========================================================================
 *  
 *  This file is part of ua Interpreter.
 *  
 *  ua Interpreter is free software: you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License as published
 *  by the Free Software Foundation, either version 3 of the License, or (at
 *  your option) any later version.
 *  
 *  ua Interpreter is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with ua Interpreter.  If not, see <http://www.gnu.org/licenses/>.
 *  
 *  (C) Copyright 2017, Gabor Kecskemeti (g.kecskemeti@ljmu.ac.uk)
 */
package uk.ac.ljmu.fet.cs.comp.interpreter.tokens;

import uk.ac.ljmu.fet.cs.comp.interpreter.interfaces.Visited;

public abstract class Expression<L extends Expression, R extends Expression> implements Visited {
	public final int myloc;
	private int myPC;
	public final L left;
	public final R right;

	public Expression(int loc, L l, R r) {
		myloc = loc + 1;
		left = l;
		right = r;
	}

	public void setPC(int pc) {
		myPC = pc;
		if (left != null)
			left.setPC(pc);
		if (right != null)
			right.setPC(pc);
	}

	public int getPC() {
		return myPC;
	}

	public abstract String toOriginalUA();

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(loc: " + myloc + " L: " + (left == null ? "-" : left) + "," + " R: "
				+ (right == null ? "-" : right) + ")";
	}
}
