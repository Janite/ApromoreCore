/*-
 * #%L
 * This file is part of "Apromore Core".
 * %%
 * Copyright (C) 2018 - 2020 Apromore Pty Ltd.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */
/*
 * $Id: SVGUtils.java,v 1.1 2009/09/25 15:14:15 david Exp $
 * Copyright (c) 2006, David Benson
 * 
 * All rights reserved. 
 * 
 * This file is licensed under the JGraph software license, a copy of which
 * will have been provided to you in the file LICENSE at the root of your
 * installation directory. If you are unable to locate this file please
 * contact JGraph sales for another copy.
 */
package org.apromore.jgraph.io.svg;

import java.awt.Color;

/**
 * Various utility methods to assist producing an SVG representation of the 
 * graph
 */
public class SVGUtils {

	/**
	 * Global linespacing.
	 */
	public static int LINESPACING = 4;

	/** Represents the black color hex encoding. */
	public static String HEXCOLOR_BLACK = getHexEncoding(Color.BLACK);

	/** Represents the white color hex encoding. */
	public static String HEXCOLOR_WHITE = getHexEncoding(Color.WHITE);

	/**
	 * Returns the hex encoding for the specified color.
	 */
	public static String getHexEncoding(Color color) {
		String c = "";
		if (color == null) {
			c = "none";
		} else {
			c = Integer.toHexString(color.getRGB() & 0x00ffffff);

			// Pads with zeros
			while (c.length() < 6) {
				c += "0";
			}
			c = "#" + c;
		}
		return c;
	}
}
