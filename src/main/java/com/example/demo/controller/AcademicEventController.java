@RestController
@RequestMapping("/api/academic-events")
public class AcademicEventController {

    @Autowired
    private AcademicEventService academicEventService;

    @PostMapping
    public AcademicEvent createEvent(@RequestBody AcademicEvent event) {
        return academicEventService.createEvent(event);
    }

    @GetMapping
    public List<AcademicEvent> getAllEvents() {
        return academicEventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public AcademicEvent getEventById(@PathVariable Long id) {
        return academicEventService.getEventById(id);
    }

    @GetMapping("/branch/{branchId}")
    public List<AcademicEvent> getEventsByBranch(@PathVariable Long branchId) {
        return academicEventService.getEventsByBranch(branchId);
    }

    @PutMapping("/{id}")
    public AcademicEvent updateEvent(
            @PathVariable Long id,
            @RequestBody AcademicEvent event) {
        return academicEventService.updateEvent(id, event);
    }
}
