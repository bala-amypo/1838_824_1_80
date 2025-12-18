



public class EventMergeRecord {
    private Long id;
    private String sourceEventIds;
    private String mergedTitle;
    private LocalDate mergedStartDate;
    private LocalDate mergedEndDate;
    private String mergeReason;
    private LocalDateTime createdAt;
    public void ValidateAndInitializer() {
        this.createdAt = LocalDateTime.now();
        this.mergedStartDate = LocalDate.now();
        this mergedEndDate = LocalDate.now();
    }
}