/*
 * Copyright 2018 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.particleframework.discovery.event;

import org.particleframework.context.env.ComputePlatform;
import org.particleframework.context.env.DefaultEnvironment;
import org.particleframework.context.env.Environment;
import org.particleframework.discovery.ServiceInstance;
import org.particleframework.discovery.cloud.AmazonMetadataResolver;
import org.particleframework.discovery.cloud.ComputeInstanceMetadata;

import javax.inject.Inject;
import java.util.Optional;
import java.util.Set;

/**
 * An event fired when registering a service
 *
 * @author graemerocher
 * @since 1.0
 */
public class ServiceStartedEvent extends AbstractServiceInstanceEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */

    @Inject
    Environment environment;

    @Inject
    DefaultEnvironment defaultEnvironment;


    public ServiceStartedEvent(ServiceInstance source) {
        super(source);
        //Environment is null, how do I get this properly??
        //Set activeNames = environment.getActiveNames();
        //if (activeNames.contains(Environment.AMAZON_EC2)) {
            AmazonMetadataResolver resolver = new AmazonMetadataResolver();
            Optional metaData = resolver.resolve(ComputePlatform.AMAZON_EC2);
        //}

    }
}
