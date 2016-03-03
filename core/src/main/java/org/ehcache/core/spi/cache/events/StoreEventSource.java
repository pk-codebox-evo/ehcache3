/*
 * Copyright Terracotta, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ehcache.core.spi.cache.events;

import org.ehcache.core.spi.cache.Store;

/**
 * Interface to enable listening and configuring the {@link Store} eventing system.
 */
public interface StoreEventSource<K, V> {

  void addEventListener(StoreEventListener<K, V> eventListener);

  void removeEventListener(StoreEventListener<K, V> eventListener);

  /**
   * Adds an event filter. When multiple event filters are added, an event must be accepted by all to be valid.
   *
   * @param eventFilter the event filter
   */
  void addEventFilter(StoreEventFilter<K, V> eventFilter);

  /**
   * Toggles event ordering, which means events will respect ordering of operations on a key basis.
   *
   * @param ordering {@code true} if ordering is desired, {@code false} for no ordering
   */
  void setEventOrdering(boolean ordering);

  /**
   * Indicates if the current store is delivering events ordered or not.
   *
   * @return {@code true} if ordering is on, {@code false} otherwise
   */
  boolean isEventOrdering();
}