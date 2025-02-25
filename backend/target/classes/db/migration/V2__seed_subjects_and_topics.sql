-- First insert all subjects
INSERT INTO subjects (id, name, code, description) VALUES 
('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Mathematics', '0580', 'IGCSE Mathematics covers number, algebra, geometry, and statistics'),
('a1eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'Physics', '0625', 'IGCSE Physics explores matter, forces, energy, and waves'),
('a2eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'Biology', '0610', 'IGCSE Biology covers living organisms, their structure, and life processes');

-- Then insert all topics with matching subject_id references
INSERT INTO topics (id, subject_id, name, description, learning_objectives, recommended_hours) VALUES
-- Mathematics Topics
('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Number', 'Integers, fractions, decimals, and percentages', 'Understanding number systems, operations, and their applications', 20),
('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Algebra', 'Expressions, equations, and functions', 'Manipulating algebraic expressions and solving equations', 25),
('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Geometry', 'Shapes, space, and measures', 'Understanding geometric concepts and spatial relationships', 25),
('b0eebc99-9c0b-4ef8-bb6d-6bb9bd380a14', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Statistics', 'Data handling and probability', 'Collecting, processing, and interpreting data', 15),

-- Physics Topics
('b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a21', 'a1eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'Forces and Motion', 'Speed, acceleration, and Newton''s laws', 'Understanding mechanics and motion', 20),
('b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a22', 'a1eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'Electricity', 'Current, voltage, and circuits', 'Understanding electrical concepts and circuit analysis', 15),
('b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a23', 'a1eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'Waves', 'Sound and light waves', 'Understanding wave properties and behavior', 15),
('b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a24', 'a1eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'Energy', 'Energy transfers and conservation', 'Understanding energy forms and transformations', 15),

-- Biology Topics
('b2eebc99-9c0b-4ef8-bb6d-6bb9bd380a31', 'a2eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'Cell Biology', 'Cell structure and organization', 'Understanding cell components and functions', 15),
('b2eebc99-9c0b-4ef8-bb6d-6bb9bd380a32', 'a2eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'Human Biology', 'Human organ systems', 'Understanding human anatomy and physiology', 25),
('b2eebc99-9c0b-4ef8-bb6d-6bb9bd380a33', 'a2eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'Reproduction', 'Plant and animal reproduction', 'Understanding reproductive processes', 15),
('b2eebc99-9c0b-4ef8-bb6d-6bb9bd380a34', 'a2eebc99-9c0b-4ef8-bb6d-6bb9bd380a13', 'Ecology', 'Organisms and their environment', 'Understanding ecological relationships', 15); 