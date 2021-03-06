/*
 * Copyright 1999-2011 University of Chicago
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.globus.workspace.xen.xenssh;

import org.globus.workspace.WorkspaceException;
import org.globus.workspace.cmdutils.SSHUtil;
import org.globus.workspace.scheduler.defaults.ResourcepoolEntry;
import org.globus.workspace.xen.XenRequest;
import org.globus.workspace.xen.XenUtil;

import java.util.ArrayList;

/**
 * @author Carla Souza
 * @date 07/06/11 00:16
 */
public class Query extends XenRequest {

    protected void init() throws WorkspaceException {
        this.name = "Query";
        this.doFakeLag = true;

        final ResourcepoolEntry vmm = this.ctx.getVmm();
        final ArrayList ssh = SSHUtil.constructSshCommand(vmm.getHostname());
        final ArrayList exe = XenUtil.constructQueryCommand();
        ssh.addAll(exe);
        this.cmd = (String[]) ssh.toArray(new String[ssh.size()]);

    }


}
