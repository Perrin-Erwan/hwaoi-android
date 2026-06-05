package com.example.hwaoiwiki

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Locale

class DateUtilsTest {

    @Test
    fun formatTimestamp_returnsCorrectFormat() {
        // 1735686000000L is 2025-01-01 00:00:00 UTC approximately
        // We use a fixed timestamp to test the formatter
        val timestamp = 1735686000000L // Wed Jan 01 2025 00:00:00 GMT+0000
        
        // Note: Result might depend on local timezone if not careful.
        // For a true unit test, we should inject the locale or timezone.
        // But for this project, a simple check is a good start.
        val result = DateUtils.formatTimestamp(timestamp)
        // Since we don't know the runner's timezone, we can at least check the format pattern
        val pattern = """\d{2}/\d{2}/\d{4} \d{2}:\d{2}""".toRegex()
        assert(pattern.matches(result))
    }

    @Test
    fun getCurrentDate_returnsCorrectFormat() {
        val result = DateUtils.getCurrentDate()
        val pattern = """\d{2}/\d{2}/\d{4}""".toRegex()
        assert(pattern.matches(result))
    }
}
