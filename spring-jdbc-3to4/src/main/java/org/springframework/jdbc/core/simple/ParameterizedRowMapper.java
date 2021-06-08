/*
 * Copyright 2002-2008 the original author or authors.
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

package org.springframework.jdbc.core.simple;

import org.springframework.jdbc.core.RowMapper;

/**
 * Extension of the {@link org.springframework.jdbc.core.RowMapper} interface,
 * adding type parameterization. As of Spring 3.0, this is equivalent to using
 * the RowMapper interface directly.
 * 
 * notify: in Sprign 4.0 , this interface is removed from spring-jdbc.jar, so
 * for some old project which depends on this interface , we add it to the whole
 * project as a service pack.
 * 
 * org.springframework.jdbc.core.simple.SimpleJdbcOperations
 * @author Rob Harrop
 * @author Juergen Hoeller
 * @author Jann Liu
 * @since 2.0
 * @see org.springframework.jdbc.core.simple.SimpleJdbcOperations
 */
public interface ParameterizedRowMapper<T> extends RowMapper<T> {

}
