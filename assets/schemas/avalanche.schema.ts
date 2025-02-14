export const avalancheSchema = {
    $schema: 'http://json-schema.org/draft-07/schema',
    $id: 'http://example.com/example.json',
    type: 'object',
    title: 'Avalanche Schema',
    description: 'Contains all extra properties for Avalanche',
    properties: {
        'com.ivanti.enterprise.extra.ENROLLMENT_SERVER': {
            $id: '#/properties/com.ivanti.enterprise.extra.ENROLLMENT_SERVER',
            type: 'string',
            title: 'Avalanche Enrollment Server',
        },
        'com.ivanti.enterprise.extra.ENROLLMENT_ID': {
            $id: '#/properties/com.ivanti.enterprise.extra.ENROLLMENT_ID',
            type: 'string',
            title: 'Avalanche Enrollment ID',
        },
        'com.ivanti.enterprise.extra.ENROLLMENT_PWD': {
            $id: '#/properties/com.ivanti.enterprise.extra.ENROLLMENT_PWD',
            type: 'string',
            title: 'Avalanche Password',
        }
    },
    dependencies: {
        'com.ivanti.enterprise.extra.ENROLLMENT_SERVER': {
            required: ['com.ivanti.enterprise.extra.ENROLLMENT_ID',
                'com.ivanti.enterprise.extra.ENROLLMENT_PWD']
        },
        'com.ivanti.enterprise.extra.ENROLLMENT_ID': {
            required: ['com.ivanti.enterprise.extra.ENROLLMENT_SERVER',
                'com.ivanti.enterprise.extra.ENROLLMENT_PWD']
        },
        'com.ivanti.enterprise.extra.ENROLLMENT_PWD': {
            required: ['com.ivanti.enterprise.extra.ENROLLMENT_SERVER',
                'com.ivanti.enterprise.extra.ENROLLMENT_ID']
        }
    }
};
