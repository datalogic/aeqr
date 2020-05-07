export const suremdmSchema = {
    $schema: 'http://json-schema.org/draft-07/schema',
    $id: 'http://example.com/example.json',
    type: 'object',
    title: 'SureMDM Schema',
    description: 'Contains all extra properties for SureMDM',
    properties: {
        AccountId: {
            $id: '#/properties/AccountId',
            type: 'string',
            title: 'SureMDM Account ID',
        },
        ServerPath: {
            $id: '#/properties/ServerPath',
            type: 'string',
            title: 'SureMDM Server Path',
        },
        GroupPath: {
            $id: '#/properties/GroupPath',
            type: 'string',
            title: 'SureMDM Group Path',
        },
        HttpHeader: {
            $id: '#/properties/HttpHeader',
            enum: [
                'https://',
                'http://'
            ],
            title: 'SureMDM Http Header',
        },
        DeviceNameType: {
            $id: '#/properties/DeviceNameType',
            enum: [
                'UseSystemGenerated',
                'SetManually',
                'UseIMEI',
                'UseMac',
                'UseSerialNumber',
                'UsePhoneNumber'
            ],
            title: 'SureMDM Device Name',
        },
        ShowCheckListScreen: {
            $id: '#/properties/ShowCheckListScreen',
            enum: [
                'True',
                'False'
            ],
            title: 'SureMDM Show Check List Screen',
        }
    },
    dependencies: {
        // SureMDM
        AccountId: { required: ['ServerPath', 'GroupPath', 'HttpHeader', 'DeviceNameType', 'ShowCheckListScreen'] },
        ServerPath: { required: ['AccountId'] },
        GroupPath: { required: ['AccountId'] },
        HttpHeader: { required: ['AccountId'] },
        DeviceNameType: { required: ['AccountId'] },
        ShowCheckListScreen: { required: ['AccountId'] }
    }
};
