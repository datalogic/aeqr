export const mobileironSchema = {
    $schema: 'http://json-schema.org/draft-07/schema',
    $id: 'http://example.com/example.json',
    type: 'object',
    title: 'MobileIron Schema',
    description: 'Contains all extra properties for MobileIron',
    properties: {
        server: {
            $id: '#/properties/server',
            type: 'string',
            title: 'MobileIron Server',
        },
        token: {
            $id: '#/properties/token',
            type: 'string',
            title: 'MobileIron Token',
        },
        quickStart: {
            $id: '#/properties/quickStart',
            type: 'boolean',
            title: 'MobileIron Quick Start',
        }
    },
    dependencies: {
        server: { required: ['quickStart'] },
        token: { required: ['server'] }
    },
    allOf: [
        {
            if: {
                properties: { quickStart: { const: true } },
                required: ['quickStart']
            },
            then: {
                required: ['server']
            }
        }
    ]
};
