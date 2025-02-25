INSERT INTO subjects (id, name, code, description, created_at, updated_at) 
VALUES 
('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Test Subject', 'TEST101', 'Test Description', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO topics (id, subject_id, name, description, learning_objectives, recommended_hours, created_at, updated_at)
VALUES 
('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Test Topic', 'Test Description', 'Test Objectives', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP); 