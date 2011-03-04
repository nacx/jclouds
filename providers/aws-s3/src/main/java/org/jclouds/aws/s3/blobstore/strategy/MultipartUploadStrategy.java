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

package org.jclouds.aws.s3.blobstore.strategy;

import org.jclouds.aws.s3.blobstore.strategy.internal.SequentialMultipartUploadStrategy;
import org.jclouds.blobstore.domain.Blob;

import com.google.inject.ImplementedBy;

/**
 * @see <a href="http://docs.amazonwebservices.com/AmazonS3/latest/dev/index.html?qfacts.html"
 *
 * @author Tibor Kiss
 */
@ImplementedBy(SequentialMultipartUploadStrategy.class)
public interface MultipartUploadStrategy {
   
   /* Maximum number of parts per upload */
   public static final int MAX_NUMBER_OF_PARTS = 10000;
   /* Maximum number of parts returned for a list parts request */
   public static final int MAX_LIST_PARTS_RETURNED = 1000;
   /* Maximum number of multipart uploads returned in a list multipart uploads request */
   public static final int MAX_LIST_MPU_RETURNED = 1000;
   
   /*
    * part size 5 MB to 5 GB, last part can be < 5 MB
    */
   public static final long MIN_PART_SIZE = 5242880L;
   public static final long MAX_PART_SIZE = 5368709120L;
      
   String execute(String container, Blob blob);
   
}
