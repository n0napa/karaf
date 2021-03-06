/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.karaf.jms.command;

import java.util.List;

import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.apache.karaf.shell.support.table.ShellTable;

@Command(scope = "jms", name = "connectionfactories", description = "List the JMS connection factories")
@Service
public class ConnectionFactoriesCommand extends JmsCommandSupport {

    @Override
    public Object execute() throws Exception {

        ShellTable table = new ShellTable();
        table.column("JMS Connection Factory");

        List<String> connectionFactories = getJmsService().connectionFactories();
        for (String connectionFactory : connectionFactories) {
            table.addRow().addContent(connectionFactory);
        }

        table.print(System.out);

        return null;
    }

}
