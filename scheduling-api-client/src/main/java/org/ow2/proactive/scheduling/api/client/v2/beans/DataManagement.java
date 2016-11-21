/*
 *  *
 * ProActive Parallel Suite(TM): The Java(TM) library for
 *    Parallel, Distributed, Multi-Core Computing for
 *    Enterprise Grids & Clouds
 *
 * Copyright (C) 1997-2015 INRIA/University of
 *                 Nice-Sophia Antipolis/ActiveEon
 * Contact: proactive@ow2.org or contact@activeeon.com
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; version 3 of
 * the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
 * USA
 *
 * If needed, contact us to obtain a release under GPL Version 2 or 3
 * or a different license than the AGPL.
 *
 *  Initial developer(s):               The ProActive Team
 *                        http://proactive.inria.fr/team_members.htm
 *  Contributor(s):
 *
 *  * $$ACTIVEEON_INITIAL_DEV$$
 */
package org.ow2.proactive.scheduling.api.client.v2.beans;

import lombok.Data;

import static org.ow2.proactive.scheduling.api.client.v2.beans.ApiTypeKeyEnum.DATA_MANAGEMENT;
import static org.ow2.proactive.scheduling.api.client.v2.beans.ApiTypeKeyEnum.GLOBLE_SPACE_URL;
import static org.ow2.proactive.scheduling.api.client.v2.beans.ApiTypeKeyEnum.INPUT_SPACE_URL;
import static org.ow2.proactive.scheduling.api.client.v2.beans.ApiTypeKeyEnum.OUTPUT_SPACE_URL;
import static org.ow2.proactive.scheduling.api.client.v2.beans.ApiTypeKeyEnum.USER_SPACE_URL;
import static org.ow2.proactive.scheduling.api.client.v2.beans.Constants.RETURN;

@Data
public class DataManagement implements ApiType {

    private final String queryString;

    private DataManagement(String queryString) {
        this.queryString = queryString;
    }

    public static class Builder {

        private boolean globalSpaceUrl = true;
        private boolean inputSpaceUrl = true;
        private boolean outputSpaceUrl = true;
        private boolean userSpaceUrl = true;

        private StringBuilder sb = new StringBuilder();

        public Builder excludeGlobalSpaceUrl() {
            this.globalSpaceUrl = false;
            return this;
        }

        public Builder excludeInputSpaceUrl() {
            this.inputSpaceUrl = false;
            return this;
        }

        public Builder excludeOutputSpaceUrl() {
            this.outputSpaceUrl = false;
            return this;
        }

        public Builder excludeUserSpaceUrl() {
            this.userSpaceUrl = false;
            return this;
        }

        public DataManagement build() {
            sb.append(DATA_MANAGEMENT.getKey());
            sb.append("{").append(RETURN);
            if(globalSpaceUrl) {
                sb.append(GLOBLE_SPACE_URL.getKey()).append(RETURN);
            }
            if(inputSpaceUrl) {
                sb.append(INPUT_SPACE_URL.getKey()).append(RETURN);
            }
            if(outputSpaceUrl) {
                sb.append(OUTPUT_SPACE_URL.getKey()).append(RETURN);
            }
            if(userSpaceUrl) {
                sb.append(USER_SPACE_URL.getKey()).append(RETURN);
            }
            sb.append("}").append(RETURN);
            return new DataManagement(sb.toString());
        }
    }
}