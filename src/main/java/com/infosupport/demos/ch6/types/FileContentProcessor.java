package com.infosupport.demos.ch6.types;

import java.io.File;
import java.util.List;

interface FileContentProcessor {
    // Reads path and puts the contents in either binaryContents OR textContents
    void processContents(File path,
                         byte[] binaryContents,
                         List<String> textContents);
}
