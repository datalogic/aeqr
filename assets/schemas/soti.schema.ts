export const sotiSchema = {
    $schema: 'http://json-schema.org/draft-07/schema',
    $id: 'http://example.com/example.json',
    type: 'object',
    title: 'SOTI Schema',
    description: 'Contains all extra properties for SOTI MobiControl',
    properties: {
        enrollmentId: {
            $id: '#/properties/enrollmentId',
            type: 'string',
            title: 'Soti Enrollment ID',
        }
    }
};
