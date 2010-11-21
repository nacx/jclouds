/**
 *
 * Copyright (C) 2010 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
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
 * ====================================================================
 */

package org.jclouds.elastichosts.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import org.jclouds.elastichosts.domain.internal.BaseDrive;

import com.google.common.collect.ImmutableSet;

/**
 * 
 * @author Adrian Cole
 */
public class CreateDriveRequest extends BaseDrive {
   public static class Builder extends BaseDrive.Builder {
      private Set<String> avoid = ImmutableSet.of();

      public Builder avoid(Iterable<String> avoid) {
         this.avoid = ImmutableSet.copyOf(checkNotNull(avoid, "avoid"));
         return this;
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder claimType(ClaimType claimType) {
         return Builder.class.cast(super.claimType(claimType));
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder encryptionCipher(String encryptionCipher) {
         return Builder.class.cast(super.encryptionCipher(encryptionCipher));
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder name(String name) {
         return Builder.class.cast(super.name(name));
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder readers(Iterable<String> readers) {
         return Builder.class.cast(super.readers(readers));
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder size(long size) {
         return Builder.class.cast(super.size(size));
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder tags(Iterable<String> tags) {
         return Builder.class.cast(super.tags(tags));
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder userMetadata(Map<String, String> userMetadata) {
         return Builder.class.cast(super.userMetadata(userMetadata));
      }

      public CreateDriveRequest build() {
         return new CreateDriveRequest(name, size, claimType, readers, tags, userMetadata, encryptionCipher, avoid);
      }
   }

   private final Set<String> avoid;

   public CreateDriveRequest(String name, long size, @Nullable ClaimType claimType, Iterable<String> readers,
         Iterable<String> tags, Map<String, String> userMetadata, @Nullable String encryptionCipher,
         Iterable<String> avoid) {
      super(name, size, claimType, readers, tags, userMetadata, encryptionCipher);
      this.avoid = ImmutableSet.copyOf(checkNotNull(avoid, "avoid"));
   }

   /**
    * 
    * @return list of existing drives to ensure this new drive is created on physical different
    *         hardware than those existing drives
    */
   public Set<String> getAvoid() {
      return avoid;
   }

}