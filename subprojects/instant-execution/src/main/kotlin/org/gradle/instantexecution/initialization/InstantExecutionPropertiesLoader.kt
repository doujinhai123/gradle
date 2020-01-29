/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.instantexecution.initialization

import org.gradle.initialization.IGradlePropertiesLoader


class InstantExecutionPropertiesLoader(
    private val startParameter: InstantExecutionStartParameter,
    private val propertiesLoader: IGradlePropertiesLoader
) {
    private
    var loaded = false

    val hasLoaded
        get() = loaded

    fun loadProperties() {
        require(!hasLoaded)
        propertiesLoader.loadProperties(startParameter.rootDirectory)
        loaded = true
    }
}