/*-
 * #%L
 * This file is part of "Apromore Core".
 * 
 * Copyright (C) 2012 - 2017 Queensland University of Technology.
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

package org.apromore.plugin.portal.calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import org.apromore.plugin.property.RequestParameterType;
import org.apromore.portal.dialogController.MainController;
import org.apromore.portal.dialogController.dto.VersionDetailType;
import org.apromore.portal.model.VersionSummaryType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Span;
import org.zkoss.zul.Window;

public class CalendarItemRenderer implements ListitemRenderer {

    private static Logger LOGGER = LoggerFactory.getLogger(CalendarItemRenderer.class);

    public Listcell renderCell(Listitem listItem, Component comp) {
        Listcell listCell = new Listcell();
        listCell.appendChild(comp);
        listItem.appendChild(listCell);
        return listCell;
    }

    public Listcell renderTextCell(Listitem listItem, String content) {
        return renderCell(listItem, new Label(content));
    }

    public Listcell renderIconCell(Listitem listItem, String sclass) {
        Span span = new Span();
        span.setSclass(sclass);
        return renderCell(listItem, span);
    }

    public void edit() {
        try {
            Map arg = new HashMap<>();
            arg.put("arg", "");
            Window window = (Window) Executions.getCurrent().createComponents("calendar/zul/calendar.zul", null, arg);
            window.doModal();
        } catch(Exception e) {
            LOGGER.error("Unable to create custom calendar dialog", e);
            // Notification.error("Unable to create custom calendar dialog");
        }
    }

    public void remove() {

    }

    @Override
    public void render(Listitem listItem, Object obj, int index) {
        CalendarItem calendarItem = (CalendarItem) obj;

        renderTextCell(listItem, calendarItem.getName());
        OffsetDateTime created = calendarItem.getCreated();
        renderTextCell(listItem, created.format(DateTimeFormatter.ofPattern("yyyy MMM dd")));
        Listcell editAction = renderIconCell(listItem, "ap-icon ap-icon-user-edit");
        Listcell removeAction = renderIconCell(listItem, "ap-icon ap-icon-trash");

        editAction.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                edit();
            }
        });

        removeAction.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                edit();
            }
        });

        listItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                edit();
            }
        });
    }

}
