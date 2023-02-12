enum class Command(val command: String) {
    START("/start"),
    HELP("/help"),
    END("/end"),
    RETURN("/return"),
    PARK_BY_CAR("/park_info_by_car"),
    PARK_BY_PLACE("/park_info_by_place"),
    PARK("/park"),
    PARK_STATS("/park_stats"),
    PARK_ALL_STATS("/park_all_stats")
}