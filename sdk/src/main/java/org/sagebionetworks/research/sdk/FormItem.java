/*
 *    Copyright 2017 Sage Bionetworks
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

package org.sagebionetworks.research.sdk;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.sagebionetworks.research.sdk.result.Result;

/**
 * Describes a form input within a step. Contains information about data type and hints on how
 * the UI should be displayed.
 */
public interface FormItem {
    @NonNull
    String getIdentifier();

    /**
     * a localized string that displays a short text offering a hint to the user of the
     * data to be entered for this field.
     *
     * @return prompt for form item
     */
    @Nullable
    String getPrompt();

    /**
     * A localized string that displays placeholder information for the form item.
     * <p>
     * You can display placeholder text in a text field or text area to help users understand how
     * to answer the item's question.
     *
     * @return placeholder for text input field
     */
    @Nullable
    String getPlaceholderText();

    void validate();

    boolean validateResult(@NonNull Result result);
}
