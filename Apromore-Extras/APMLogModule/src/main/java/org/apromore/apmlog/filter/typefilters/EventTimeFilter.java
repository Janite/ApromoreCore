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
package org.apromore.apmlog.filter.typefilters;

import org.apromore.apmlog.AActivity;
import org.apromore.apmlog.AEvent;
import org.apromore.apmlog.filter.rules.LogFilterRule;
import org.apromore.apmlog.filter.rules.RuleValue;
import org.apromore.apmlog.filter.types.Choice;
import org.apromore.apmlog.filter.types.OperationType;


public class EventTimeFilter {

    public static boolean toKeep(AActivity aActivity, LogFilterRule logFilterRule) {
        Choice choice = logFilterRule.getChoice();
        switch (choice) {
            case RETAIN: return conformRule(aActivity, logFilterRule);
            default: return !conformRule(aActivity, logFilterRule);
        }
    }

    private static boolean conformRule(AActivity aActivity, LogFilterRule logFilterRule) {


        long fromTime = 0, toTime = 0;
        for (RuleValue ruleValue : logFilterRule.getPrimaryValues()) {
            OperationType operationType = ruleValue.getOperationType();
            if (operationType == OperationType.GREATER_EQUAL) fromTime = ruleValue.getLongValue();
            if (operationType == OperationType.LESS_EQUAL) toTime = ruleValue.getLongValue();
        }

        return aActivity.getStartTimeMilli() >= fromTime && aActivity.getEndTimeMilli() <= toTime;

    }


    public static boolean toKeep(AEvent event, LogFilterRule logFilterRule) {
        Choice choice = logFilterRule.getChoice();
        switch (choice) {
            case RETAIN: return conformRule(event, logFilterRule);
            default: return !conformRule(event, logFilterRule);
        }
    }

    private static boolean conformRule(AEvent event, LogFilterRule logFilterRule) {

        if (event.getLifecycle().equals("")) return false;

        long eventEpochMilli = event.getTimestampMilli();

        long fromTime = 0, toTime = 0;
        for (RuleValue ruleValue : logFilterRule.getPrimaryValues()) {
            OperationType operationType = ruleValue.getOperationType();
            if (operationType == OperationType.GREATER_EQUAL) fromTime = ruleValue.getLongValue();
            if (operationType == OperationType.LESS_EQUAL) toTime = ruleValue.getLongValue();
        }

        return withinTimeRange(fromTime, toTime, eventEpochMilli);

    }

    private static boolean withinTimeRange(long fromTime, long toTime, long eventEpochMilli) {
        return eventEpochMilli >= fromTime && eventEpochMilli <= toTime;
    }
}
