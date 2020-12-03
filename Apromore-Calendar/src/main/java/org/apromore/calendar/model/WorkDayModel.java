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
 * This is a Pojo which is a DTO to WorkDay model in JPA.
 * This contains all WorkDay information which is associated with a calendar.
 * This is used in calculation of duration, where the number of hours is the difference between start and end
 * time for a holiday period.
 * The start and end time is adjusted for the start and end day, based on the time provided in the argument.
 */
package org.apromore.calendar.model;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.apromore.commons.datetime.TimeUtils;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class WorkDayModel {

  @EqualsAndHashCode.Exclude
  private Long id;

  private DayOfWeek dayOfWeek;

  private OffsetTime startTime;

  private OffsetTime endTime;

  private boolean workingDay = true;

  @EqualsAndHashCode.Exclude
  private String createdBy;

  @EqualsAndHashCode.Exclude
  private String updatedBy;

  @EqualsAndHashCode.Exclude
  private Duration duration;

  static LocalDate refDate=Instant
  .ofEpochMilli( 0L )
  .atOffset(ZoneOffset.UTC)
  .toLocalDate();

  public OffsetTime getAdjustedStartTime(OffsetTime time) {
    return Duration.between(startTime, time).isNegative() ? startTime : time;

  }

  public OffsetTime getAdjustedEndTime(OffsetTime time) {
    return Duration.between(time, endTime).isNegative() ? endTime : time;
  }

  public Duration getSameDayDurationByStartTime(OffsetTime startTime) {
    Duration duration = Duration.between(getAdjustedStartTime(startTime), endTime);
    return duration.isNegative() ? Duration.ZERO : duration;
  }
  
  public Duration getSameDayDurationByEndTime(OffsetTime endTime) {
    Duration duration = Duration.between(startTime,getAdjustedEndTime(endTime));
    return duration.isNegative() ? Duration.ZERO : duration;
  }

  
  public Date getStartTimeInDate()
  {
	 return TimeUtils.localDateAndOffsetTimeToDate(refDate, startTime);
  }
  
  public Date getEndTimeInDate()
  {
	 return TimeUtils.localDateAndOffsetTimeToDate(refDate, startTime);
  }

}
