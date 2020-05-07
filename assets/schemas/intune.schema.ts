export const intuneSchema = {
    $schema: 'http://json-schema.org/draft-07/schema',
    $id: 'http://example.com/example.json',
    type: 'object',
    title: 'Intune Schema',
    description: 'Contains all extra properties for Intune',
    properties: {
        'com.google.android.apps.work.clouddpc.EXTRA_ENROLLMENT_TOKEN': {
            $id: '#/properties/com.google.android.apps.work.clouddpc.EXTRA_ENROLLMENT_TOKEN',
            type: 'string',
            title: 'Intune Enrollment Token',
        }
    }
};
