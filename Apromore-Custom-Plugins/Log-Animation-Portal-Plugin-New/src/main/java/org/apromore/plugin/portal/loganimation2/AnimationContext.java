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
package org.apromore.plugin.portal.loganimation2;

import org.apromore.service.loganimation2.replay.AnimationLog;

/**
 * Animation global parameters
 * 
 * @author Bruce Nguyen
 *
 */
public class AnimationContext {
	private int recordingFrameRate = 60; //frames per second
    private double recordingFrameInterval =  1.0/recordingFrameRate*1000; //milliseconds between two consecutive frames
    private int recordingDuration = 600; //seconds
    
    private long logStartTimestamp;
    private long logEndTimestamp;
    private double logToRecordingTimeRatio = 1; //a second on the animation timeline is converted to actual seconds
    private double logTimeFrameInterval; // frame interval in terms of log time (milliseconds)
    
    private int frameSkip = 0;
    
    public AnimationContext(AnimationLog log) {
        this.logStartTimestamp = log.getStartDate().getMillis();
        this.logEndTimestamp = log.getEndDate().getMillis();
        if (recordingDuration > 0) {
            this.logToRecordingTimeRatio = (logEndTimestamp - logStartTimestamp)/(recordingDuration*1000);
            this.logTimeFrameInterval = logToRecordingTimeRatio*recordingFrameInterval;
        }
    }
    
    public boolean isValid() {
        return (recordingDuration > 0 && logEndTimestamp > logStartTimestamp && recordingFrameRate > 0);
    }
    
    public int getRecordingFrameRate() {
        return this.recordingFrameRate;
    }
    
    public void setFrameRate(int fps) {
        if (fps > 0) {
            this.recordingFrameRate = fps;
            this.recordingFrameInterval = 1.0/fps*1000;    
            this.logTimeFrameInterval = logToRecordingTimeRatio*recordingFrameInterval;
        }
    }
    
    public int getMaxNumberOfFrames() {
    	return this.recordingFrameRate*this.recordingDuration;
    }
    
    public double getFrameInterval() {
        return this.recordingFrameInterval;
    }
    
    public long getStartTimestamp() {
        return this.logStartTimestamp;
    }
    
    public long getEndTimestamp() {
        return this.logEndTimestamp;
    }
    
    public int getTotalDuration() {
        return this.recordingDuration;
    }
    
    //Unit: seconds
    public void setTotalDuration(int recordingDuration) {
        if (recordingDuration > 0) {
            this.recordingDuration = recordingDuration;
            this.logToRecordingTimeRatio = (logEndTimestamp - logStartTimestamp)/(recordingDuration*1000);
            this.logTimeFrameInterval = logToRecordingTimeRatio*recordingFrameInterval;
        }
    }
    
    public double getTimelineRatio() {
        return this.logToRecordingTimeRatio;
    }
    
    /**
     * 
     * @param timestamp: milliseconds since 1/1/1970
     */
    public int getFrameIndexFromLogTimestamp(long timestamp) {
        if (timestamp <= logStartTimestamp) {
            return 0; 
        }
        else if (timestamp >= logEndTimestamp) {
            return getMaxNumberOfFrames() - 1;
        }
        else {
            return (int)Math.floor(1.0*(timestamp - logStartTimestamp)/logTimeFrameInterval);
        }
    }
    
    public void setFrameSkip(int frameSkip) {
        this.frameSkip = frameSkip;
    }
    
    public int getFrameSkip() {
        return this.frameSkip;
    }
    
}