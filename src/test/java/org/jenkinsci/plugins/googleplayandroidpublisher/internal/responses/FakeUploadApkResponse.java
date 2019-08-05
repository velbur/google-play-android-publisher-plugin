package org.jenkinsci.plugins.googleplayandroidpublisher.internal.responses;

import com.google.api.client.googleapis.media.MediaHttpUploader;

/**
 * <pre>POST https://www.googleapis.com/upload/androidpublisher/v3/applications/org.jenkins.appId/edits/the-edit-id/apks?uploadType=resumable</pre>
 * <p>
 * This request will result in a {@code Location} redirect, which will be automatically handled by the {@link MediaHttpUploader}.
 * The continuation of the request should be handled by {@link FakePutApkResponse}.
 *
 * @see com.google.api.services.androidpublisher.AndroidPublisher.Edits.Apks#upload
 * @see FakePutApkResponse
 */
public class FakeUploadApkResponse extends FakeHttpResponse<FakeUploadApkResponse> {
    public FakeUploadApkResponse willContinue() {
        // The MediaHttpUploader automatically looks for the Location redirect, and then applies a PUT request to that URL.
        addHeader("Location", "https://google.local/uploading/foo/apk");
        return success();
    }
}
