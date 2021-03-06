/**
 * MIT License
 *
 * Copyright (c) 2019 lin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
/*-
 * #%L
 * This file is part of "Apromore Core".
 *
 * Copyright (C) 2020 University of Tartu
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
package org.apromore.service.csvimporter.dateparser;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * This is an convenience utils for {@link DateParser}.
 *
 * @author sulin
 * @since 2019-09-15 11:19:31
 */
public final class DateParserUtils {

    private DateParserUtils() {
    }

    private static final DateParserBuilder builder = DateParser.newBuilder();
    private static DateParser dateParser = builder.build();

    /**
     * Parse the specified String into Date instance, it will convert different TimeZone into system's default zone.
     *
     * @param str Datetime string like '2019-10-01 00:10:20 +0800'
     * @return Parsed datetime as Date
     */
    public static synchronized Date parseDate(String str) {
        return dateParser.parseDate(str);
    }

    /**
     * Parse the specified String into Calendar instance, it will convert different TimeZone into system's default zone.
     *
     * @param str Datetime string like '2019-10-01 00:10:20 +0800'
     * @return Parsed datetime as Calendar
     */
    public static synchronized Calendar parseCalendar(String str) {
        return dateParser.parseCalendar(str);
    }

    /**
     * Parse the specified String into LocalDateTime, it will convert different TimeZone into system's default zone.
     *
     * @param str Datetime string like '2019-10-01 +08:00'
     * @return Parsed datetime as LocalDateTime
     */
    public static synchronized LocalDateTime parseDateTime(String str) {
        return dateParser.parseDateTime(str);
    }

    /**
     * Parse the specified String into OffsetDateTime, use +00:00 as default ZoneOffset.
     *
     * @param str Datetime string like '2019-10-01'
     * @return Parsed datetime as OffsetDateTime
     */
    public static synchronized OffsetDateTime parseOffsetDateTime(String str) {
        return dateParser.parseOffsetDateTime(str);
    }

    /**
     * Setup the current Utils prefer mm/dd or not.
     *
     * @param preferMonthFirst Prefer dd/mm or mm/dd
     */
    public static synchronized void preferMonthFirst(boolean preferMonthFirst) {
        dateParser.setPreferMonthFirst(preferMonthFirst);
    }

    /**
     * Register new standard parse rules, all captured group should have the specified names.
     *
     * @param re The regex of rule
     */
    public static synchronized void registerStandardRule(String re) {
        builder.addRule(re);
        dateParser = builder.build();
    }

    /**
     * Register new customized parse rules.
     *
     * @param re      The regex of rule, like '\d{8}'
     * @param handler The handler for this rule
     */
    public static synchronized void registerCustomizedRule(String re, RuleHandler handler) {
        builder.addRule(re, handler);
        dateParser = builder.build();
    }


    public static boolean getPreferMonthFirst() {
       return dateParser.getPreferMonthFirst();
    }

}
