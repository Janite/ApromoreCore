/**
 * Copyright (c) 2011-2012 Felix Mannhardt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * See: http://www.opensource.org/licenses/mit-license.php
 *
 */
package org.apromore.common.converters.epml.handler.epml.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import de.epml.TypeEvent;
import de.epml.TypePosition;
import org.apromore.common.converters.epml.context.EPMLConversionContext;
import org.oryxeditor.server.diagram.basic.BasicNode;

public class TypeEventHandler extends NodeHandler {

    final TypeEvent event;

    public TypeEventHandler(EPMLConversionContext context, TypeEvent event) {
        super(context);
        this.event = event;
    }

    /* (non-Javadoc)
      * @see org.apromore.common.converters.epml.impl.NodeConverter#convertProperties()
      */
    @Override
    protected Map<String, String> convertProperties() {
        // TODO extends for all properties
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("title", event.getName());
        hashMap.put("description", event.getDescription());
        return hashMap;
    }

    /* (non-Javadoc)
      * @see org.apromore.common.converters.epml.impl.NodeConverter#createShape()
      */
    @Override
    protected BasicNode createShape() {
        return new BasicNode(getShapeId().toString(), "Event");
    }

    /* (non-Javadoc)
      * @see org.apromore.common.converters.epml.impl.NodeConverter#getPosition()
      */
    @Override
    protected TypePosition getPosition() {
        if (event.getGraphics() != null) {
            return event.getGraphics().getPosition();
        } else {
            TypePosition position = new de.epml.ObjectFactory().createTypePosition();
            position.setX(BigDecimal.valueOf(0));
            position.setY(BigDecimal.valueOf(30));
            position.setWidth(BigDecimal.valueOf(100));
            position.setHeight(BigDecimal.valueOf(60));
            return position;
        }

    }

    /* (non-Javadoc)
      * @see org.apromore.common.converters.epml.impl.NodeConverter#getShapeId()
      */
    @Override
    protected BigInteger getShapeId() {
        return event.getId();
    }

}
