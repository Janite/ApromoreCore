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
package org.apromore.plugin.portal.calendar;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.apromore.dao.model.Role;
import org.apromore.dao.model.User;
import org.apromore.portal.common.notification.Notification;
import org.apromore.portal.common.UserSessionManager;
import org.apromore.portal.model.PermissionType;
import org.apromore.portal.model.UserType;
import org.apromore.plugin.portal.DefaultPortalPlugin;
import org.apromore.plugin.portal.PortalContext;
import org.apromore.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

@Component("calendarPlugin")
public class CalendarPlugin extends DefaultPortalPlugin {

    private static Logger LOGGER = LoggerFactory.getLogger(CalendarPlugin.class);

    private String label = "Custom calendar";
    private String groupLabel = "Settings";

    @Override
    public String getLabel(Locale locale) {
        return label;
    }

    @Override
    public String getGroupLabel(Locale locale) {
        return groupLabel;
    }

    @Override
    public void execute(PortalContext portalContext) {

        try {
            // Present the calendar window
            Map arg = new HashMap<>();
            arg.put("portalContext", portalContext);
            Window window = (Window) Executions.getCurrent().createComponents("calendar/zul/calendars.zul", null, arg);
            window.doModal();

        } catch(Exception e) {
            LOGGER.error("Unable to create custom calendar dialog", e);
            Notification.error("Unable to create custom calendar dialog");
        }
    }

    @Override
    public Availability getAvailability() {
        return Availability.AVAILABLE;
    }
}
