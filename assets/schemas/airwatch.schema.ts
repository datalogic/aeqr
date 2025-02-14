export const airwatchSchema = {
    $schema: 'http://json-schema.org/draft-07/schema',
    $id: 'http://example.com/example.json',
    type: 'object',
    title: 'Airwatch Schema',
    description: 'Contains all extra properties for Airwatch',
    properties: {
        serverurl: {
            $id: '#/properties/serverurl',
            type: 'string',
            title: 'Airwatch Server URL',
        },
        gid: {
            $id: '#/properties/gid',
            type: 'string',
            title: 'Airwatch Group User ID',
        },
        un: {
            $id: '#/properties/un',
            type: 'string',
            title: 'AirWatch User Name',
        },
        pw: {
            $id: '#/properties/pw',
            type: 'string',
            title: 'Airwatch Password',
        },
        aospEnrollment: {
            $id: '#/properties/aospEnrollment',
            enum: [
                'True',
                'False'
            ],
            title: 'Airwatch AOSP Enrollment',
        }
    },
    dependencies: {
        un: { required: ['serverurl', 'pw'] },
        pw: { required: ['un'] },
        gid: { required: ['serverurl'] },
        aospEnrollment: { required: ['serverurl'] },
    }
};
