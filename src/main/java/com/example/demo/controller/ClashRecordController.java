package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashRecordService service;

    public ClashRecordController(ClashRecordService service) {
        this.service = service;
    }

    // POST /api/clashes - Log a clash
    @PostMapping
    public ClashRecord logClash(@RequestBody ClashRecord clashRecord) {
        return service.logClash(clashRecord);
    }

    // PUT /api/clashes/{id}/resolve - Resolve a clash
    @PutMapping("/{id}/resolve")
    public ClashRecord resolveClash(@PathVariable Long id) {
        return service.resolveClash(id);
    }

    // GET /api/clashes/event/{eventId} - Get clashes for event
    @GetMapping("/event/{eventId}")
    public List<ClashRecord> getClashesByEvent(@PathVariable Long eventId) {
        return service.getClashesByEventId(eventId);
    }

    // GET /api/clashes/unresolved - List unresolved clashes
    @GetMapping("/unresolved")
    public List<ClashRecord> getUnresolvedClashes() {
        return service.getUnresolvedClashes();
    }

    // GET /api/clashes - List all clashes
    @GetMapping
    public List<ClashRecord> getAllClashes() {
        return service.getAllClashes();
    }
}
