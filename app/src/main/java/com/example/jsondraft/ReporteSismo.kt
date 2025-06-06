package com.example.jsondraft

data class ReporteSismo(
    val report_id: Int,
    val earthquake_id: String,
    val agency: String,
    val version: Int,
    val reported_at: String,
    val lat: String,
    val lon: String,
    val depth: String,
    val time: String,
    val locstring: String,
    val event_type: String,
    val mag: String,
    val reviewed: String,
    val additional_notes: String
)
