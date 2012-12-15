package com.futuresimple.krakdroid;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class KrakDroidContract {

    public static final String AUTHORITY = "com.futuresimple.krakdroid.Provider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    static final String PATH_DATASETS = "datasets";
    static final String PATH_SUBMISSIONS = "submissions";
    static final String PATH_SOLUTIONS = "solutions";
    static final String PATH_ANSWERS = "answers";

    interface DataSetColumns {
        static final String VALUE = "value";
    }

    interface SyncColumns {
        static final String SYNCED = "synced";
    }

    interface SubmissionsColumns {
        static final String ID = "id";

        static final String SOLUTION_ID = "solution_id";

        static final String CORRECT_COUNT = "correct_count";
        static final String SUBMITTED_AT = "submitted_at";
    }

    interface SolutionColumns {
    }

    interface AnswerColumns {
        static final String DATASET_ID = "dataset_id";
        static final String SOLUTION_ID = "solution_id";

        static final String VALUE = "value";
    }

    public static class DataSets implements BaseColumns, DataSetColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_DATASETS);
    }

    public static class Submissions implements BaseColumns, SubmissionsColumns, SyncColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_SUBMISSIONS);

        public static Uri buildSubmissionUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    public static class Solutions implements BaseColumns, SolutionColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_SOLUTIONS);
    }

    public static class Answers implements BaseColumns, AnswerColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_ANSWERS);
    }

}