-- This will be loaded automatically for tests
INSERT INTO subjects (id, name, code, description) 
VALUES 
('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'Test Mathematics', 'TEST101', 'Test mathematics description');

INSERT INTO topics (id, subject_id, name, description, learning_objectives, recommended_hours)
VALUES 
('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'Test Topic', 'Test Description', 'Test Objectives', 10); 