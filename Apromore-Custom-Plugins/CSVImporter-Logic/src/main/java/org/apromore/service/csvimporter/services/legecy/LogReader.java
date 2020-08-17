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

package org.apromore.service.csvimporter.services.legecy;

import org.apromore.service.csvimporter.model.LogModel;
import org.apromore.service.csvimporter.model.LogSample;
import org.deckfour.xes.model.XLog;

import java.io.IOException;
import java.io.InputStream;

/**
 * Service which converts event logs in CSV format to XES format.
 * <p>
 * Conversion is performed by first calling {@link #sampleCSV} to sample the beginning of the
 * CSV document and make a best guess at the meanings of the headers.
 * The sample may be corrected by hand, and then passed to the {@link #readLogs} method
 * to convert the entire document.
 * The converted XES model is obtained using {@link LogModel#getXLog}.
 */
public interface LogReader {

    /**
     * Process an entire CSV document using a given header configuration.
     *
//     * @param reader a source of CSV data; this must be open to the beginning of the data so that the header may be read
     * @param sample header configuration
     * @throws IOException if <var>reader</var> cannot read the CSV data
     */
    LogModel readLogs(InputStream in, LogSample sample, String charset, boolean skipInvalidRow) throws Exception;

}
